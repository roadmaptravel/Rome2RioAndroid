package nl.endevelopment.r2randroid.r2rlib;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

import nl.endevelopment.r2randroid.r2rlib.models.Position;
import nl.endevelopment.r2randroid.r2rlib.parser.SearchParser;
import nl.endevelopment.r2randroid.r2rlib.request.SearchRequest;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class SearchParserUnitTest {
    @Test
    public void addition_isNotNull() throws Exception {
        SearchParser searchParser = new SearchParser();
        Assert.assertNotNull(searchParser);
    }



    @Test
    public void responseNotNull(){
        SearchRequest searchRequest = new SearchRequest();
        searchRequest.setoName("London");
        searchRequest.setdName("Delft");
        searchRequest.setoPos(new Position(51.47034,-0.45342));
        searchRequest.setdPos(new Position(52.00643,4.35681));

        Call<String> call =  Rome2RioRequest.get(searchRequest);
        try {
            Response<String> response = call.execute();
            Assert.assertNotNull(response.body());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}