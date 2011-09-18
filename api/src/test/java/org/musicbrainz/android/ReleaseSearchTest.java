package org.musicbrainz.android;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;

import org.junit.Test;
import org.musicbrainz.android.api.data.ReleaseStub;
import org.musicbrainz.android.api.ws.ResponseParser;

public class ReleaseSearchTest extends BaseXmlParsingTestCase {

	@Test
	public void testReleaseSearch() {
		InputStream stream = getFileStream("releaseSearch_songs about leaving.xml");
		assertNotNull(stream);
		
		try {
			LinkedList<ReleaseStub> releases = new ResponseParser().parseReleaseSearch(stream);
			assertEquals(25, releases.size());
		} catch (IOException e) {
			e.printStackTrace();
			fail();
		}
	}

}
