/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.matrix.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;
import pl.matrix.client.ws.DoubleArray;
import pl.matrix.client.ws.Matrix;
import pl.matrix.client.ws.MatrixCalculatorWS;
import pl.matrix.client.ws.MatrixCalculatorWSImplService;

/**
 *
 * @author KaMyLuS
 */
@WebServlet(name = "MatrixCalculatorServlet", urlPatterns = {"/MatrixCalculatorServlet"})
public class MatrixCalculatorServlet extends HttpServlet {
    @WebServiceRef(wsdlLocation = "http://localhost:8080/MatrixCalculator/MatrixCalculatorWSImplService?wsdl")
    private MatrixCalculatorWSImplService service;
    
    private MatrixStringConverter matrixConverter = new MatrixStringConverter();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Rezultat</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<div id='result'>");
            
            try {
                String operationResult = this.performOperation(request);
                out.println(operationResult);
            } catch(Exception e) {
                out.println("Wystąpił błąd! Sprawdź poprawność wprowadzonych danych!");
                //out.println(e.getMessage());
            } finally {
                out.println("</div>");
                out.println("</body>");
                out.println("</html>");
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {      
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    public Matrix callSampleMatrix(double arg0) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        pl.matrix.client.ws.MatrixCalculatorWS port = service.getMatrixCalculatorWSImplPort();
        return port.sampleMatrix(arg0);
    }

    private double callCalculateTrace(Matrix m) {
        MatrixCalculatorWS port = service.getMatrixCalculatorWSImplPort();
        return port.calculateTrace(m);
    }
    
    private Matrix callAddMatrices(Matrix a, Matrix b) {
        MatrixCalculatorWS port = service.getMatrixCalculatorWSImplPort();
        return port.addMatrices(a, b);
    }
    
    private Matrix callMultiplyMatrices(Matrix a, Matrix b) {
        MatrixCalculatorWS port = service.getMatrixCalculatorWSImplPort();
        return port.multiplyMatrices(a, b);
    }
    
    private double callCalculateDeterminant(pl.matrix.client.ws.Matrix arg0) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        pl.matrix.client.ws.MatrixCalculatorWS port = service.getMatrixCalculatorWSImplPort();
        return port.calculateDeterminant(arg0);
    }

    private java.util.List<java.lang.Double> callCalculateEigenValues(pl.matrix.client.ws.Matrix arg0) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        pl.matrix.client.ws.MatrixCalculatorWS port = service.getMatrixCalculatorWSImplPort();
        return port.calculateEigenValues(arg0);
    }

    private java.util.List<pl.matrix.client.ws.Matrix> callCalculateLUDecomposition(pl.matrix.client.ws.Matrix arg0) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        pl.matrix.client.ws.MatrixCalculatorWS port = service.getMatrixCalculatorWSImplPort();
        return port.calculateLUDecomposition(arg0);
    }

    private Matrix callMultiplyByScalar(pl.matrix.client.ws.Matrix arg0, double arg1) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        pl.matrix.client.ws.MatrixCalculatorWS port = service.getMatrixCalculatorWSImplPort();
        return port.multiplyByScalar(arg0, arg1);
    }

    private Matrix callSolveLinearEquation(pl.matrix.client.ws.Matrix arg0, pl.matrix.client.ws.Matrix arg1) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        pl.matrix.client.ws.MatrixCalculatorWS port = service.getMatrixCalculatorWSImplPort();
        return port.solveLinearEquation(arg0, arg1);
    }

    private Matrix callTransformToTriangularUpperMatrix(pl.matrix.client.ws.Matrix arg0) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        pl.matrix.client.ws.MatrixCalculatorWS port = service.getMatrixCalculatorWSImplPort();
        return port.transformToTriangularUpperMatrix(arg0);
    }

    private Matrix callTransposeMatrix(pl.matrix.client.ws.Matrix arg0) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        pl.matrix.client.ws.MatrixCalculatorWS port = service.getMatrixCalculatorWSImplPort();
        return port.transposeMatrix(arg0);
    }
    
    private String performOperation(HttpServletRequest request) throws IOException {
        String operation = request.getParameter("operationType");
        String token = request.getParameter("authToken");
        
        if(operation.equals("addMatrices")) {
            Matrix a = matrixConverter.stringToMatrix(request.getParameter("a"));
            Matrix b = matrixConverter.stringToMatrix(request.getParameter("b"));
            Matrix c = this.callAddMatrices(a, b);
            
            String result = "<h1>Operacja: dodawanie macierzy</h1>" +
                    "Rezultat:<br /><br /> Każdy może przeprowadzić " + matrixConverter.matrixToString(c);
            return result;
        } else if(operation.equals("multiplyMatrices")) {
            if(token == null || token.isEmpty()) {
                String result = "<h1>Operacja: dodawanie macierzy</h1>" +
                    "Rezultat:<br /><br />" + "Brak uprawnień - gość";
                return result;
            } else if(token.equals("user:pass") || token.equals("mat:maz")) {
                Matrix a = matrixConverter.stringToMatrix(request.getParameter("a"));
                Matrix b = matrixConverter.stringToMatrix(request.getParameter("b"));
                Matrix c = this.callMultiplyMatrices(a, b);
                
                String[] splits = token.split(":");

                String result = "<h1>Operacja: mnożenie macierzy</h1>" +
                        "Witaj " + splits[0] + ", rezultat:<br /><br />" + matrixConverter.matrixToString(c);
                return result;
            } else {
                String[] splits = token.split(":");
                String result = "<h1>Operacja: dodawanie macierzy</h1>" +
                        "Witaj " + splits[0] + ", nie jestes uprawniony:<br /><br />";
                return result;
            }
        } else if(operation.equals("multiplyByScalar")) {
            if(token == null || token.isEmpty()) {
                String result = "<h1>Operacja: mnożenie macierzy przez skalar</h1>" +
                    "Rezultat:<br /><br />" + "Brak uprawnień - gość";
                return result;
            }
            
            Matrix a = matrixConverter.stringToMatrix(request.getParameter("a"));
            double b = Double.parseDouble(request.getParameter("b"));
            Matrix c = this.callMultiplyByScalar(a, b);
            
            String result = "<h1>Operacja: mnożenie macierzy przez skalar</h1>" +
                    "Rezultat:<br /><br />" + matrixConverter.matrixToString(c);
            return result;
        } else if(operation.equals("calculateDeterminant")) {
            Matrix a = matrixConverter.stringToMatrix(request.getParameter("a"));
            double c = this.callCalculateDeterminant(a);
            
            String result = "<h1>Operacja: obliczanie wyznacznika</h1>" +
                    "Rezultat:<br /><br />" + c;
            return result;
        } else if(operation.equals("calculateTrace")) {
            Matrix a = matrixConverter.stringToMatrix(request.getParameter("a"));
            double c = this.callCalculateTrace(a);
            
            String result = "<h1>Operacja: obliczanie śladu</h1>" +
                    "Rezultat:<br /><br />" + c;
            return result;
        } else if(operation.equals("transposeMatrix")) {
            Matrix a = matrixConverter.stringToMatrix(request.getParameter("a"));
            Matrix c = this.callTransposeMatrix(a);
            
            String result = "<h1>Operacja: transpozycja</h1>" +
                    "Rezultat:<br /><br />" + matrixConverter.matrixToString(c);
            return result;
        } else if(operation.equals("transformToTriangularUpperMatrix")) {
            Matrix a = matrixConverter.stringToMatrix(request.getParameter("a"));
            Matrix c = this.callTransformToTriangularUpperMatrix(a);
            
            String result = "<h1>Operacja: sprowadzenie do macierzy trójkątnej górnej</h1>" +
                    "Rezultat:<br /><br />" + matrixConverter.matrixToString(c);
            return result;
        } else if(operation.equals("calculateEigenValues")) {
            Matrix a = matrixConverter.stringToMatrix(request.getParameter("a"));
            List<Double> c = this.callCalculateEigenValues(a);
            
            String result = "<h1>Operacja: obliczanie wartości własnych</h1>" +
                    "Rezultat:<br /><br />" + c.toString();
            return result;
        } else if(operation.equals("calculateLUDecomposition")) {
            Matrix a = matrixConverter.stringToMatrix(request.getParameter("a"));
            List<Matrix> c = this.callCalculateLUDecomposition(a);
            
            String result = "<h1>Operacja: dekompozycja LU</h1>" +
                    "Rezultat:<br /><br />L:<br />" + matrixConverter.matrixToString(c.get(0))
                    + "<br />U:<br/>" + matrixConverter.matrixToString(c.get(1));
            return result;
        } else if(operation.equals("solveLinearEquation")) {
            Matrix a = matrixConverter.stringToMatrix(request.getParameter("a"));
            Matrix b = matrixConverter.stringToMatrix(request.getParameter("b"));
            Matrix c = this.callSolveLinearEquation(a, b);
            
            String result = "<h1>Operacja: rozwiązywanie układu równań</h1>" +
                    "Rezultat:<br /><br />" + matrixConverter.matrixToString(c);
            return result;
        }
        
        
        
        
        
        else {
            
        }
        return null;
    }
}
