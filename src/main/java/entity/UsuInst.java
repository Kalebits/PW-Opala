package entity;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class UsuInst {

    @JoinColumn(name="ID_UsuInst")
    @ManyToOne
    private Instrumento Id;

    
}
