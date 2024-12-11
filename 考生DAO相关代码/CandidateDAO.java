package com.example.dao;
import com.example.model.Candidate;

import java.util.List;

public interface CandidateDAO {   
    // 插入考生信息
    void insertCandidate(Candidate candidate);
    // 更新考生信息
    void updateCandidate(Candidate candidate);
    // 删除考生信息
    void deleteCandidate(String candidateId);
    // 根据考生ID查询考生
    Candidate getCandidateById(String candidateId);
    // 查询所有考生
    List<Candidate> getAllCandidates();
	
}