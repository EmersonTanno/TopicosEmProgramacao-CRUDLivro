package com.example.Livro.model;

public enum StatusReserva {
    PENDENTE,    // A reserva foi criada, mas ainda não confirmada
    CONFIRMADA,  // A reserva foi confirmada
    FINALIZADA   // A reserva foi concluída (check-out ou evento ocorrido)
}
