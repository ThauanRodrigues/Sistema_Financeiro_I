import React, { useEffect, useState } from 'react';
import api from '../api/axios';

function Lancamentos() {
    const [lancamentos, setLancamentos] = useState([]);

    useEffect(() => {
        const fetchLancamentos = async () => {
            try {
                const response = await api.get('/lancamentos');
                setLancamentos(response.data);
            } catch (error) {
                console.error('Erro ao buscar lançamentos:', error);
            }
        };

        fetchLancamentos();
    }, []);

    return (
        <div>
            <h1>Lançamentos</h1>
            <ul>
                {lancamentos.map((lancamento) => (
                    <li key={lancamento.id}>
                        {lancamento.descricao} - {lancamento.valor}
                    </li>
                ))}
            </ul>
        </div>
    );
}

export default Lancamentos;
