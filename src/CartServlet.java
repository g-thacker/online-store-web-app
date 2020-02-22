import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

//TODO: [FOR PRACTICE -- NOT PART OF THE HOMEWORK] ADD FOREACH LOOP IN CHECKOUT PAGE TO CALCULATE TOTAL COST
//TODO: MAYBE ALSO ADD TAX? "REMOVE FROM CART" BUTTON?
//TODO: REDESIGN TO TRACK STORE INVENTORY IN DATABASE AND LET USER KNOW WHEN INVENTORY IS LOW OR OUT OF STOCK?

@WebServlet(name = "CartServlet")
public class CartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ArrayList<Product> currentCart = null;
        HttpSession thisSession = request.getSession(false); // page 207
        thisSession.setMaxInactiveInterval(60*60*24); // set max inactive interval to one day
//        thisSession.setMaxInactiveInterval(-1); // set session to last until browser window is closed
        String url = "";
        String action = request.getParameter("thisAction");
        String thisId = request.getParameter("thisId");
        String thisDesc = request.getParameter("thisDesc");
        String thisPrice = request.getParameter("thisPrice");
        String thisQuant = request.getParameter("thisQuantity");

                switch (action) {
                    case "add": {
                        if (thisQuant != null && !"".equals(thisQuant)) {
                            thisSession.setAttribute("sender", "index");
                            Product thisProduct = new Product(thisId, thisDesc, thisPrice, Integer.parseInt(thisQuant));
                            if (thisSession.getAttribute("thisCart") == null && thisQuant != null && !"".equals(thisQuant)) {
                                currentCart = new ArrayList<>();
                                currentCart.add(thisProduct);
                                currentCart = Product.sortArray(currentCart);
                                thisSession.setAttribute("thisCart", currentCart);
                            } else {
                                currentCart = (ArrayList<Product>) thisSession.getAttribute("thisCart");
                                currentCart.add(thisProduct);
                                currentCart = Product.sortArray(currentCart);
                                thisSession.setAttribute("thisCart", currentCart);
                            }
                        }
                        url = "/index.jsp";
                        break;
                    }
                    case "checkout": {
                        thisSession.setAttribute("sender", "index");
                        url = "/checkout.jsp";
                        break;
                    }
                    case "update": {
                        url = "/checkout.jsp";
                        thisSession.setAttribute("sender", "checkout");
                        String adjustmentPid = request.getParameter("targetId");
                        String newQuantity = request.getParameter("newQuant");
                        currentCart = (ArrayList<Product>) thisSession.getAttribute("thisCart");
                        for (Product p : currentCart) {
                            if (p.getProdId().equals(adjustmentPid)) {
                                p.setProdQuant(Integer.parseInt(newQuantity));
                            }
                        }
                        thisSession.setAttribute("thisCart", currentCart);
                        break;
                    }
                    case "logoff": {
                        url = "/logoff.jsp";
                        thisSession.invalidate();
                    }
                }
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
