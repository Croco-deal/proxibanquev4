package fr.formation.proxibanquev4.presentation.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import fr.formation.proxibanquev4.presentation.filter.ForceEncodingFilter;

/**
 * Classe implémentant l'interface Filter permettant de spécifier l'encodage des champs de saisie de texte des pages jsp. 
 * @author JLSS
 *
 */
public class ForceEncodingFilter implements Filter {
	private static final String CHARSET = "UTF-8";

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding(ForceEncodingFilter.CHARSET);
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
	}
}
