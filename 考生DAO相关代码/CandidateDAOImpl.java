package com.example.dao;
import org.apache.ibatis.session.SqlSession;
import com.example.model.Candidate;
import com.example.util.MyBatisUtil;
import java.util.List;
import com.example.model.Candidate;

public class CandidateDAOImpl implements CandidateDAO{
	@Override
    public void insertCandidate(Candidate candidate) {
        SqlSession sqlSession = MyBatisUtil.openSession();
        try {
            sqlSession.insert("com.example.dao.CandidateMapper.insertCandidate", candidate);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public void updateCandidate(Candidate candidate) {
        SqlSession sqlSession = MyBatisUtil.openSession();
        try {
            sqlSession.update("com.example.dao.CandidateMapper.updateCandidate", candidate);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public void deleteCandidate(String candidateId) {
        SqlSession sqlSession = MyBatisUtil.openSession();
        try {
            sqlSession.delete("com.example.dao.CandidateMapper.deleteCandidate", candidateId);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public Candidate getCandidateById(String candidateId) {
        SqlSession sqlSession = MyBatisUtil.openSession();
        try {
            return sqlSession.selectOne("com.example.dao.CandidateMapper.getCandidateById", candidateId);
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public List<Candidate> getAllCandidates() {
        SqlSession sqlSession = MyBatisUtil.openSession();
        try {
            return sqlSession.selectList("com.example.dao.CandidateMapper.getAllCandidates");
        } finally {
            sqlSession.close();
        }
    }
}
