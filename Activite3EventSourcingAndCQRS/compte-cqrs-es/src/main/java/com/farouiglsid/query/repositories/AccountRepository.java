package com.farouiglsid.query.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.farouiglsid.query.entities.Account;

public interface AccountRepository extends JpaRepository<Account, String> {
}
