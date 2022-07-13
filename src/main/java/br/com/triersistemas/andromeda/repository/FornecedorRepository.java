package br.com.triersistemas.andromeda.repository;

import br.com.triersistemas.andromeda.domain.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;
@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, UUID> {

}
