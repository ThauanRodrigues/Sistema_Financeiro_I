import React, { useContext } from 'react';
import { Navigate, useLocation } from 'react-router-dom';
import { AuthContext } from '../context/AuthContext';

const PrivateRoute = ({ component: Component, ...rest }) => {
    const { usuarioAutenticado } = useContext(AuthContext);
    const location = useLocation();

    return usuarioAutenticado ? (
        <Component {...rest} />
    ) : (
        <Navigate to="/login" state={{ from: location }} />
    );
};

export default PrivateRoute;