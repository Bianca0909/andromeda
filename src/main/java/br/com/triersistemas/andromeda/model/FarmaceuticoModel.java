package br.com.triersistemas.andromeda.model;
import lombok.Getter;
import java.time.LocalDate;
import java.util.UUID;

@Getter
public class FarmaceuticoModel {
  private String nome;
  private LocalDate niver;
  private String cpf;

}
