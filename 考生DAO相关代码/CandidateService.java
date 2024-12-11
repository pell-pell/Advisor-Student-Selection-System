package com.example.service;


import com.example.model.Candidate;
import com.example.util.MyBatisUtil;

import org.apache.ibatis.session.SqlSession;

import com.example.dao.CandidateDAO;;


public class CandidateService {
	public void submitCandidate(Candidate candidateInfo) {
        SqlSession sqlSession = MyBatisUtil.openSession();
        try {
            CandidateDAO candidateDAO = sqlSession.getMapper(CandidateDAO.class);
            candidateDAO.insertCandidate(candidateInfo);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

}