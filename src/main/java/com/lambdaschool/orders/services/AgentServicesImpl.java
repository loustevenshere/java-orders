package com.lambdaschool.orders.services;

import com.lambdaschool.orders.models.Agent;
import com.lambdaschool.orders.repositories.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Transactional
@Service(value = "agentServices")
public class AgentServicesImpl implements AgentsServices {

    @Autowired
    private AgentRepository agentrepos;


    @Override
    public Agent findAgentById(long agentid) {
        return agentrepos.findById(agentid)
                .orElseThrow(() -> new EntityNotFoundException("Agent id " + agentid + " Not found"));
    }
}
