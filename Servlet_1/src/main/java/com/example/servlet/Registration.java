package com.example.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Registration extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the form parameter
        String name = request.getParameter("name");

        // Set content type for the response
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Send the response back to the browser
        out.println("<html><body>");
        out.println("<h1>Hello, " + name + "!</h1>");
        out.println("<p>Welcome to the Servlet!</p>");
        out.println("</body></html>");
    }
}
