

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.model.Candidate;
import com.example.service.CandidateService;

/**
 * Servlet implementation class GetCandidateForm
 */
@WebServlet("/GetCandidateForm")
public class GetCandidateForm extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取前端提交的数据
        String candidateId = request.getParameter("candidateId");
        String name = request.getParameter("name");
        String birthDate = request.getParameter("birthDate");
        String idCard = request.getParameter("idCard");
        String region = request.getParameter("region");
        String undergraduateMajor = request.getParameter("undergraduateMajor");
        String undergraduateSchool = request.getParameter("undergraduateSchool");
        String schoolType = request.getParameter("schoolType");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String resume = request.getParameter("resume");

        // 将数据封装成 CandidateInfo 对象
        Candidate candidateInfo = new Candidate(); 
        candidateInfo.setCandidateId(candidateId);
        candidateInfo.setName(name);
        candidateInfo.setBirthDate(java.sql.Date.valueOf(birthDate));
        candidateInfo.setIdCard(idCard);
        candidateInfo.setRegion(region);
        candidateInfo.setUndergraduateMajor(undergraduateMajor);
        candidateInfo.setUndergraduateSchool(undergraduateSchool);
        candidateInfo.setSchoolType(schoolType);
        candidateInfo.setEmail(email);
        candidateInfo.setPhone(phone);
        candidateInfo.setResume(resume);

        // 调用 Service 层处理
        CandidateService service = new CandidateService();
		service.submitCandidate(candidateInfo);

        // 返回响应
        response.getWriter().write("信息提交成功！");
    }
}