package com.eazybytes.loans.audit;

import org.hibernate.annotations.Comment;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component("auditAware")
public class AuditAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        System.out.println("j");
        return Optional.of("LOANS_MS");
    }
}
