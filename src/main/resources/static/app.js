const API_BASE_URL = 'http://localhost:8080/api';

let currentClient = null;

// Gestione Navigazione Sezioni
function showSection(sectionId) {
    const sections = ['access-section', 'shows-section', 'booking-section', 'reservations-section'];
    sections.forEach(id => {
        document.getElementById(id).classList.add('hidden');
    });
    document.getElementById(sectionId).classList.remove('hidden');

    if (sectionId === 'shows-section') loadTeatriSpettacoli();
    if (sectionId === 'reservations-section') loadReservations();
}

// Visualizzazione Avvisi di Sistema
function showAlert(message, type = 'danger') {
    const alertBox = document.getElementById('alert-box');
    alertBox.className = `alert alert-${type}`;
    alertBox.textContent = message;
    alertBox.classList.remove('hidden');
    setTimeout(() => alertBox.classList.add('hidden'), 5000);
}

// 1. Verifica Accesso Cliente (/api/biglietti/cliente/{id})
document.getElementById('login-form').addEventListener('submit', async (e) => {
    e.preventDefault();
    const codCliente = document.getElementById('login-cod-cliente').value;

    try {
        const response = await fetch(`${API_BASE_URL}/biglietti/cliente/${codCliente}`);
        if (!response.ok) {
            if (response.status === 404) throw new Error(`Cliente non trovato con codice: ${codCliente}`);
            throw new Error('Errore durante la connessione al server.');
        }

        currentClient = await response.json();
        const userInfo = document.getElementById('user-info');
        userInfo.innerHTML = `
            <p><strong>Benvenuto/a, ${currentClient.nome} ${currentClient.cognome}</strong></p>
            <p>Codice Cliente: ${currentClient.codCliente} | Email: ${currentClient.email} | Tel: ${currentClient.telefono}</p>
        `;
        userInfo.classList.remove('hidden');
        
        // Autocompila il codice cliente nel modulo di prenotazione
        document.getElementById('codCliente').value = currentClient.codCliente;
        showAlert('Accesso effettuato con successo.', 'success');
    } catch (err) {
        showAlert(err.message, 'danger');
        document.getElementById('user-info').classList.add('hidden');
        currentClient = null;
    }
});

// 2. Caricamento Teatri e Spettacoli
async function loadTeatriSpettacoli() {
    try {
        const response = await fetch(`${API_BASE_URL}/teatri`);
        if (!response.ok) throw new Error('Errore durante il recupero dei teatri.');
        const teatri = await response.json();

        const container = document.getElementById('teatri-container');
        container.innerHTML = '';

        teatri.forEach(teatro => {
            let spettacoliHtml = '';
            if (teatro.spettacoli && teatro.spettacoli.length > 0) {
                teatro.spettacoli.forEach(spettacolo => {
                    let replicheHtml = '';
                    if (spettacolo.repliche && spettacolo.repliche.length > 0) {
                        replicheHtml = spettacolo.repliche.map(r => `
                            <li>
                                Cod. Replica: <strong>${r.codreplica}</strong> | 
                                Data: ${r.dataReplica} (Ore 21.00)
                            </li>
                        `).join('');
                    } else {
                        replicheHtml = '<li>Nessuna replica disponibile.</li>';
                    }

                    spettacoliHtml += `
                        <div class="spettacolo-card">
                            <h4>${spettacolo.titolo}</h4>
                            <p>Autore: ${spettacolo.autore} | Regista: ${spettacolo.regista}</p>
                            <p>Prezzo: ${spettacolo.prezzo}€</p>
                            <ul class="repliche-list">${replicheHtml}</ul>
                        </div>
                    `;
                });
            } else {
                spettacoliHtml = '<p>Nessun spettacolo registrato per questo teatro.</p>';
            }

            const card = document.createElement('div');
            card.className = 'teatro-card';
            card.innerHTML = `
                <h3>${teatro.nome} (Cod: ${teatro.codTeatro})</h3>
                <p>Indirizzo: ${teatro.indirizzo} - ${teatro.citta} (${teatro.provincia})</p>
                <p>Telefono: ${teatro.telefono} | Capienza: <strong>${teatro.posti} posti</strong></p>
                <hr>
                <h5>Spettacoli:</h5>
                ${spettacoliHtml}
            `;
            container.appendChild(card);
        });
    } catch (err) {
        showAlert(err.message, 'danger');
    }
}

// 3. Inserimento Prenotazione (POST /api/biglietti/compra)
document.getElementById('booking-form').addEventListener('submit', async (e) => {
    e.preventDefault();

    const codCliente = document.getElementById('codCliente').value;
    const codreplica = document.getElementById('codreplica').value;
    const quantita = document.getElementById('quantita').value;
    const tipoPagamento = document.getElementById('tipoPagamento').value;

    const params = new URLSearchParams({
        codCliente: codCliente,
        codreplica: codreplica,
        quantita: quantita,
        tipoPagamento: tipoPagamento
    });

    try {
        const response = await fetch(`${API_BASE_URL}/biglietti/compra?${params.toString()}`, {
            method: 'POST'
        });

        if (!response.ok) {
            const errorText = await response.text();
            throw new Error(errorText || 'Errore durante l\'acquisto del biglietto!');
        }

        const resultBiglietto = await response.json();
        showAlert(`Prenotazione effettuata con successo! Codice Operazione: ${resultBiglietto.codOperazione}`, 'success');
        document.getElementById('booking-form').reset();
    } catch (err) {
        showAlert(err.message, 'danger');
    }
});

// 4. Caricamento Prenotazioni
async function loadReservations() {
    try {
        const response = await fetch(`${API_BASE_URL}/biglietti`);
        if (!response.ok) throw new Error('Errore durante il recupero delle prenotazioni.');
        const biglietti = await response.json();

        const tbody = document.getElementById('reservations-table-body');
        tbody.innerHTML = '';

        biglietti.forEach(b => {
            const row = document.createElement('tr');

            const clienteNome = b.cliente ? `${b.cliente.cognome} ${b.cliente.nome}` : '-';
            const spettacolo = b.replicha?.spettacolo;
            const teatroNome = spettacolo?.teatro ? spettacolo.teatro.nome : '-';
            const spettacoloInfo = spettacolo ? `${spettacolo.titolo} (${spettacolo.autore})` : '-';
            const dataReplica = b.replicha ? b.replicha.dataReplica : '-';
            const dataOraFormatted = b.dataOra ? new Date(b.dataOra).toLocaleString('it-IT') : '-';

            row.innerHTML = `
                <td><strong>${b.codOperazione}</strong></td>
                <td>${clienteNome}</td>
                <td>${teatroNome}</td>
                <td>${spettacoloInfo}</td>
                <td>${dataReplica}</td>
                <td>21.00</td>
                <td>${b.quantita}</td>
                <td>${b.tipoPagamento}</td>
                <td>${dataOraFormatted}</td>
            `;
            tbody.appendChild(row);
        });
    } catch (err) {
        showAlert(err.message, 'danger');
    }
}

