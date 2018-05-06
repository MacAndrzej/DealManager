package info.deal.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


public class ApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	/**
	 * Set configuration class.
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { ApplicationConfiguration.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}
/**
 * Set DispatcherServlet on "/"
 */
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}
}
