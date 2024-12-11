<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>考生信息提交</title>
</head>
<body>
    <h2>考生信息表</h2>
    <form action="GetCandidateForm" method="post">
        <div>
            <label for="candidateId">考生ID:</label>
            <input type="text" id="candidateId" name="candidateId" required />
        </div>
        <div>
            <label for="name">姓名:</label>
            <input type="text" id="name" name="name" required />
        </div>
        <div>
            <label for="birthDate">出生日期:</label>
            <input type="date" id="birthDate" name="birthDate" required />
        </div>
        <div>
            <label for="idCard">身份证号:</label>
            <input type="text" id="idCard" name="idCard" required pattern="\d{17}[\dXx]" />
        </div>
        <div>
            <label for="region">地区:</label>
            <input type="text" id="region" name="region" />
        </div>
        <div>
            <label for="undergraduateMajor">本科专业:</label>
            <input type="text" id="undergraduateMajor" name="undergraduateMajor" />
        </div>
        <div>
            <label for="undergraduateSchool">本科院校:</label>
            <input type="text" id="undergraduateSchool" name="undergraduateSchool" />
        </div>
        <div>
            <label for="schoolType">院校类型:</label>
            <input type="text" id="schoolType" name="schoolType" />
        </div>
        <div>
            <label for="email">邮箱:</label>
            <input type="email" id="email" name="email" required />
        </div>
        <div>
            <label for="phone">电话:</label>
            <input type="tel" id="phone" name="phone" required pattern="\d{11}" />
        </div>
        <div>
            <label for="resume">个人简历:</label>
            <textarea id="resume" name="resume"></textarea>
        </div>
        <div>
            <button type="submit">提交</button>
        </div>
    </form>
   
</body>
</html>