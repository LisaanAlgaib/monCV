package fr.hugonaze.cv.filters;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

/**
 * Servlet Filter implementation class EncodingFilter
 * Définit l'encodage UTF-8 pour toute requête entrante.
 * 
 * Possible de mettre en place ce principe en s'appuyant sur le 
 * CharacterEncodingFilter
 */
@WebFilter(dispatcherTypes = {DispatcherType.REQUEST }
, urlPatterns = { "/*" })
public class EncodingFilter extends HttpFilter implements Filter {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String encoding = "UTF-8";
	
    /**
     * Default constructor. 
     */
    public EncodingFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		// Respect the client-specified character encoding
        // (see HTTP specification section 3.4.1)
        //if (null == request.getCharacterEncoding()) {
        //    request.setCharacterEncoding(encoding);
        //}
		request.setCharacterEncoding(encoding);

        // Set the default response content type and encoding
        //response.setContentType("text/html; charset=UTF-8");
        

		// pass the request along the filter chain
		chain.doFilter(request, response);
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		
		//Dans le cas ou un paramètre d'encodage spécifique était défini dans la config
		String encodingParam = fConfig.getInitParameter("encoding");
		if (encodingParam != null) {
			this.encoding = encodingParam;
		}
		
	}
}
