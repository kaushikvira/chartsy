package org.chartsy.srift;

import java.awt.Color;
import java.awt.Stroke;
import java.beans.PropertyEditorSupport;
import java.util.logging.Level;
import org.chartsy.main.chart.AbstractPropertiesNode;
import org.chartsy.main.utils.SerialVersion;
import org.chartsy.main.utils.StrokeGenerator;
import org.chartsy.main.utils.StrokePropertyEditor;
import org.openide.nodes.Sheet;

/**
 *
 * @author Viorel
 */
public class IndicatorNode extends AbstractPropertiesNode
{

	private static final long serialVersionUID = SerialVersion.APPVERSION;

	public IndicatorNode()
	{
		super("Smoothed RSI Inverse Fisher Transform Properties");
	}

	public IndicatorNode(IndicatorProperties indicatorProperties)
	{
		super("Smoothed RSI Inverse Fisher Transform Properties",
			indicatorProperties);
	}

	@SuppressWarnings("unchecked")
    protected @Override Sheet createSheet()
    {
        Sheet sheet = Sheet.createDefault();
        Sheet.Set set = getPropertiesSet();
        sheet.put(set);

        try
        {
            // RSI Period
            set.put(getProperty(
                    "RSI Period", // property name
                    "Sets the RSI period value", // property description
                    IndicatorProperties.class, // properties class
                    int.class, // property class
                    null, // property editor class (null if none)
                    "getRsiPeriod", // get method name
                    "setRsiPeriod", // set method name
                    IndicatorProperties.RSI_PERIOD // default property value
                    ));
			// EMA Period
            set.put(getProperty(
                    "EMA Period", // property name
                    "Sets the EMA period value", // property description
                    IndicatorProperties.class, // properties class
                    int.class, // property class
                    null, // property editor class (null if none)
                    "getEmaPeriod", // get method name
                    "setEmaPeriod", // set method name
                    IndicatorProperties.EMA_PERIOD // default property value
                    ));
			// EMA Period
            set.put(getProperty(
                    "SVE Rainbow Weighted Period", // property name
                    "Sets the period value for SVE Rainbow Weighted", // property description
                    IndicatorProperties.class, // properties class
                    int.class, // property class
                    null, // property editor class (null if none)
                    "getSvePeriod", // get method name
                    "setSvePeriod", // set method name
                    IndicatorProperties.SVE_PERIOD // default property value
                    ));
            // Label
            set.put(getProperty(
                    "Label", // property name
                    "Sets the label", // property description
                    IndicatorProperties.class, // properties class
                    String.class, // property class
                    PropertyEditorSupport.class, // property editor class (null if none)
                    "getLabel", // get method name
                    "setLabel", // set method name
                    IndicatorProperties.LABEL // default property value
                    ));
            // Marker Visibility
            set.put(getProperty(
                    "Marker Visibility", // property name
                    "Sets the marker visibility", // property description
                    IndicatorProperties.class, // properties class
                    boolean.class, // property class
                    null, // property editor class (null if none)
                    "getMarker", // get method name
                    "setMarker", // set method name
                    IndicatorProperties.MARKER // default property value
                    ));
            // Line Color
            set.put(getProperty(
                    "Line Color", // property name
                    "Sets the line color", // property description
                    IndicatorProperties.class, // properties class
                    Color.class, // property class
                    null, // property editor class (null if none)
                    "getColor", // get method name
                    "setColor", // set method name
                    IndicatorProperties.COLOR // default property value
                    ));
            // Line Style
            set.put(getProperty(
                    "Line Style", // property name
                    "Sets the line style", // property description
                    IndicatorProperties.class, // properties class
                    Stroke.class, // property class
                    StrokePropertyEditor.class, // property editor class (null if none)
                    "getStroke", // get method name
                    "setStroke", // set method name
                    StrokeGenerator.getStroke(IndicatorProperties.STROKE_INDEX) // default property value
                    ));
        }
        catch (NoSuchMethodException ex)
        {
            LOG.log(Level.SEVERE, "[SRIFTNode] : Method does not exist.", ex);
        }

        return sheet;
    }

}