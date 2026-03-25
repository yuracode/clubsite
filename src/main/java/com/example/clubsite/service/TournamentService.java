package com.example.clubsite.service;

import com.example.clubsite.mapper.TournamentMapper;
import com.example.clubsite.model.Tournament;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TournamentService {
    private final TournamentMapper tournamentMapper;

    public List<Tournament> findByYear(int year) {
        return tournamentMapper.findByYear(year);
    }

    public List<Tournament> findAll() {
        return tournamentMapper.findAll();
    }

    public void save(Tournament tournament) {
        tournamentMapper.insert(tournament);
    }
}
