import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Source;
import org.graalvm.polyglot.Value;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.UUID;

import static java.text.MessageFormat.format;

public class PolyglotFeatures {

    public int pageSeoFeature(String input) throws IOException {
        try (Context context = Context.newBuilder("python").allowAllAccess(true).build()) {
            Value featureRegistry = context.eval(python("feature_registry.py"));
            return featureRegistry.invokeMember("page_seo", input).asInt();
        }
    }

    public int aggregational(String featureName, Object... arguments) throws IOException {
        try (Context context = Context.newBuilder("python").allowAllAccess(true).build()) {
            Value featureRegistry = context.eval(python("feature_registry.py"));
            return featureRegistry.invokeMember(featureName, arguments).asInt();
        }
    }


    private static Source python(String filename) throws IOException {
        URL resource = PolyglotFeatures.class.getResource(filename);
        if (resource == null) throw new FileNotFoundException("No " + filename + " found.");
        return Source.newBuilder("python", resource).build();
    }

    private static void println(String message, Object... arguments) {
        System.out.println(format(message, arguments));
    }

    public static void main(String[] args) throws IOException {
        PolyglotFeatures polyglotFeatures = new PolyglotFeatures();
        String pages = "[{\"page_id\":\"cjg9\",\"json_filename\":\"0f41c5_513c6ca8679510ad94679544aeeb52f0_1.json\"},{\"page_id\":\"uw218\",\"json_filename\":\"0f41c5_24c2c3552bcc679227cc2e9f16485aef_9.json\"},{\"page_id\":\"c1rzs\",\"json_filename\":\"0f41c5_3db190ad28d13b648f96939b62afa83e_1.json\"},{\"page_id\":\"c24vq\",\"json_filename\":\"0f41c5_9d48526bdfd37c1fb46b3cb41df3e67e_1.json\"},{\"page_id\":\"c1lug\",\"json_filename\":\"0f41c5_9fc60d8fbd4617784582d04a19687ef2_1.json\"},{\"page_id\":\"cee5\",\"json_filename\":\"0f41c5_f677e7ccdd0a5669c480d88966e0492f_1.json\"}]";
        int pageSeo = polyglotFeatures.pageSeoFeature(pages);
        println("Page SEO feature: {0}", pageSeo);

        String msid = UUID.randomUUID().toString();
        int count_save_site = polyglotFeatures.aggregational("count_save_site", msid);
        println("Site {0} saved {1} times.", msid, count_save_site);
    }
}
