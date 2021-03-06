/**
 * 
 */
package ss.common.textformatting.obtainscenarios;

import java.util.ArrayList;
import java.util.List;

import ss.common.StringUtils;
import ss.common.textformatting.ComplexMultiKeywordFormatResolver;
import ss.common.textformatting.RawSingleKeywordFormatResolver;

/**
 * @author zobo
 *
 */
public class ObtainNotesScenario extends DefaultObtainScenario {
	
	@SuppressWarnings("unused")
	private static final org.apache.log4j.Logger logger = ss.global.SSLogger
			.getLogger(ObtainNotesScenario.class);

	private static final String NOTE = "note";
	
	public final static ObtainNotesScenario INSTANCE = new ObtainNotesScenario();
	
	/* (non-Javadoc)
	 * @see ss.common.textformatting.obtainscenarios.DefaultObtainScenario#obtain(java.lang.String)
	 */
	public List<String> obtain( final String text ) {
		if ( StringUtils.isBlank( text ) ) {
			return null;
		}
		final List<String> results = new ArrayList<String>();
		try {
			final List<String> rawResults = RawSingleKeywordFormatResolver.INSTANCE.parse( text, NOTE );
			if ( (rawResults != null) && (!rawResults.isEmpty()) ) {
				results.addAll( rawResults );
			}
		} catch ( Exception ex ){
			logger.error( "error getting raw format",ex );
		}
		try {
			final List<String> complexResults = ComplexMultiKeywordFormatResolver.INSTANCE.parse( text, NOTE );
			if ( (complexResults != null) && (!complexResults.isEmpty()) ) {
				results.addAll( complexResults );
			}
		} catch ( Exception ex ){
			logger.error( "error getting raw format",ex );
		}
		return results;
	}
}
