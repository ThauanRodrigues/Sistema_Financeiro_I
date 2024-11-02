import React, { createContext, useState } from 'react';

export const AuthContext = createContext();

export const AuthProvider = ({ children }) => {
    const [usuarioAutenticado, setUsuarioAutenticado] = useState(null);

    const login = (usuario) => {
        setUsuarioAutenticado(usuario);
    };

    const logout = () => {
        setUsuarioAutenticado(null);
    };

    return (
        <AuthContext.Provider value={{ usuarioAutenticado, login, logout }}>
            {children}
        </AuthContext.Provider>
    );
};
