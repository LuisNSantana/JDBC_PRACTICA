package controller;

import modelo.Tarea;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet("/AltaTarea")
public class AltaTarea extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AltaTarea() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**private void redirigir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     RequestDispatcher dispacher = request.getRequestDispatcher("listaTareas.jsp");
     dispacher.forward(request, response);
     }*/

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        //response.getWriter().append("Served at: ").append(request.getContextPath());
        String id =request.getParameter("id");
        String opcion =request.getParameter("opcion");
        try {
            switch (opcion) {
                case "1":
                    nuevaTarea(request, response);
                    break;
                case "2":
                    borrarTarea(request, response);
                    break;
                case "3":
                    buscarTarea(request, response);
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        }catch(Exception e) {
            e.printStackTrace();
        }



		/*SimpleDateFormat fecha_ini= new SimpleDateFormat("MM/dd/yyyy");
		String fecha_inicio=request.getParameter("fecha_inicio");
		fecha_inicio=fecha_ini.format(new Date());

		SimpleDateFormat fecha_f= new SimpleDateFormat("MM/dd/yyyy");
		String fecha_fin=request.getParameter("fecha_fin");
		fecha_fin=fecha_f.format(new Date());*/
		/*
		Date fecha_inicio=new Date();
		Date fecha_fin=new Date();

		try {
			fecha_inicio=new SimpleDateFormat().parse(request.getParameter("fecha_inicio"));
		}catch(ParseException | java.text.ParseException e) {
			e.printStackTrace();
		}

		try {
			fecha_fin=new SimpleDateFormat().parse(request.getParameter("fecha_fin"));
		}catch(ParseException | java.text.ParseException e) {
			e.printStackTrace();
		} */




        // request.setAttribute("listaTripu",lista);





        //String id = "0";


        //id = request.getAttribute("id").toString();
        //}

        //response.sendRedirect("tareas.jsp");
        //Tarea tr= new Tarea();
        //tr.buscarID(Integer.parseInt(id));
        //getServletConfig().getServletContext().getRequestDispatcher("/tareas.jsp").forward(resquest, response);
        //response.sendRedirect("tareas.jsp");


        //response.getWriter().print("<h1>"+t.toString()+"</h1>");


    }

    private void buscarTarea(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        //Tarea t = new Tarea (Integer.parseInt(request.getParameter("id")), request.getParameter("titulo"),
        //	request.getParameter("descripcion"), request.getParameter("categoria"),
        //request.getParameter("importancia"),request.getParameter("depende"),
        //	request.getParameter("fecha_inicio"), request.getParameter("fecha_fin"),
        //request.getParameter("estado"));

        int id;

        if (Integer.parseInt(request.getParameter("id")) != 0) {
            id = Integer.parseInt(request.getParameter("id"));
            request.setAttribute("id", id);
            RequestDispatcher vista = request.getRequestDispatcher("menu.jsp");
            vista.forward(request, response);
        } else {
            request.setAttribute("id", null);
            RequestDispatcher vista = request.getRequestDispatcher("menu.jsp");
            vista.forward(request, response);
        }
        // TODO Auto-generated method stub

    }

    private void borrarTarea(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Tarea t = new Tarea();
        t.buscarID(Integer.parseInt(request.getParameter("id")));
        t.borrar();
        response.sendRedirect("menu.jsp");
        // TODO Auto-generated method stub

    }

    private void nuevaTarea(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String titulo= request.getParameter("titulo");
        String descripcion= request.getParameter("descripcion");
        Integer categoria= Integer.parseInt(request.getParameter("categoria"));
        Integer importancia= Integer.parseInt(request.getParameter("importancia"));
        Integer depende= Integer.parseInt(request.getParameter("depende"));
        Integer estado= Integer.parseInt(request.getParameter("estado"));
        LocalDate fecha_inicio = null;//LocalDate.parse(request.getParameter("fecha_inicio"), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalDate fecha_fin = null;//LocalDate.parse(request.getParameter("fecha_fin"), DateTimeFormatter.ofPattern("dd/MM/yyyy"));


        Tarea t= new Tarea(titulo,descripcion,categoria,importancia,depende,fecha_inicio, fecha_fin, estado);

        if (request.getParameter("id") != "") {
            try {
                t.setId(Integer.parseInt(request.getParameter("id")));
                t.actualizar();
            }catch (NumberFormatException e){
                System.out.println("not a number");
            }

        } else
            t.insertar();

        //response.sendRedirect("menu.jsp");

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
