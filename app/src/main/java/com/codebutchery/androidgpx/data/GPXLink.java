package com.codebutchery.androidgpx.data;

import java.io.PrintStream;
import java.util.ArrayList;

/**
 * Created by thorin on 24/02/2017.
 */

public class GPXLink extends GPXBaseEntity {

    public static class XML {

        public static final String TAG_LINK = "link";

        public static final String ATTR_HREF = "href";

        public static final String TAG_TEXT = "text";
        public static final String TAG_TYPE = "type";

    };

    @SuppressWarnings("unused")
    private static final String TAG = "GPXLink";

    /**
     * Href as String
     * */
    private String mHref = null;

    /**
     * Text as String
     * */
    private String mText = null;

    /**
     * Type as String
     * */
    private String mType = null;

    /**
     * Href is mandatory
     * in order to construct this object
     *
     * */
    public GPXLink(String href) {
        mHref = href;
    }

    public String getHref() {
        return mHref;
    }

    public String getText() {
        return mText;
    }

    public void setText(String mText) {
        this.mText = mText;
    }

    public String getType() {
        return mType;
    }

    public void setType(String mType) {
        this.mType = mType;
    }

    public void toGPX(PrintStream ps) {

        ArrayList<String> attrsNames = new ArrayList<String>();
        ArrayList<String> attrsValues = new ArrayList<String>();

        attrsNames.add(XML.ATTR_HREF);

        attrsValues.add(getHref());

        openXmlTag(XML.TAG_LINK, ps, attrsNames, attrsValues, true, 2);

        putStringValueInXmlIfNotNull(XML.TAG_TEXT, getText(), ps, 3);
        putStringValueInXmlIfNotNull(XML.TAG_TYPE, getType(), ps, 3);

        closeXmlTag(XML.TAG_LINK, ps, true, 2);

    }
}
