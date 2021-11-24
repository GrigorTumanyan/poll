package com.servlet;

import com.impl.AnswerDaoImpl;
import com.impl.QuestionDaoImpl;
import com.model.Answer;
import com.model.Question;
import lombok.SneakyThrows;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/PollLiveLoving")
public class LiveLovingServlet extends HttpServlet {
    private final QuestionDaoImpl QUESTION_DAO = new QuestionDaoImpl();
    private final AnswerDaoImpl ANSWER_DAO = new AnswerDaoImpl();

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        Map<Question, List<Answer>> questionAnswerMap = new HashMap<>();
        List<Question> questionByPollId = QUESTION_DAO.findByPollId(2);
        for (Question question : questionByPollId) {
            List<Answer> byQuestionId = ANSWER_DAO.findByQuestionId(question.getId());
            questionAnswerMap.put(question, byQuestionId);
        }
        req.getSession().setAttribute("questionAnswerMap", questionAnswerMap);
        req.getRequestDispatcher("WEB-INF/poll.jsp").forward(req, resp);
    }
}
