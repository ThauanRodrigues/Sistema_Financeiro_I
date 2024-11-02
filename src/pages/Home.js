import React, { useContext, useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { AuthContext } from '../context/AuthContext';
import UsuarioService from '../services/UsuarioService';
import './Home.css';

const Home = () => {
  const { usuarioAutenticado } = useContext(AuthContext);
  const [saldo, setSaldo] = useState(0);
  const navigate = useNavigate();

  useEffect(() => {
    const usuarioService = new UsuarioService();
    if (usuarioAutenticado) {
      usuarioService.obterSaldoUsuario(usuarioAutenticado.id).then(response => {
        setSaldo(response.data);
      }).catch(error => {
        console.log(error);
      });
    }
  }, [usuarioAutenticado]);

  const cadastrarLancamentos = () => {
    navigate('/cadastro-lancamento');
  };

  const verLancamentos = () => {
    navigate('/consulta-lancamento');
  };

  const primeiroNome = () => {
    const primeiroNome = usuarioAutenticado.nome.split(' ').shift();
    return primeiroNome.toUpperCase().charAt(0).concat(primeiroNome.slice(1));
  };

  const saldoClass = saldo > 0 ? 'saldo positivo' : 'saldo negativo';

  return (
    <div className="jumbotron" id="dark-1">
      <h1 className="display-3">
        Bem Vindo {primeiroNome()}!
      </h1>
      <p className="lead">
        Essa é a sua área administrativa. <br />
        Veja o seu saldo atual
      </p>
      <p className={saldoClass}>
        {new Intl.NumberFormat('pt-BR', {
          style: 'currency',
          currency: 'BRL'
        }).format(saldo)}
      </p>
      <hr className="lead" />
      <p className="lead">
        <button onClick={cadastrarLancamentos} className="btn btn-success">
          Novo Lançamento
        </button>
        <button onClick={verLancamentos} className="btn btn-secondary">
          Ver Lançamentos
        </button>
      </p>
    </div>
  );
};

export default Home;