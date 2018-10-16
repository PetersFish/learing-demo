package cn.peter.jenkins;

import com.offbytwo.jenkins.JenkinsServer;
import com.offbytwo.jenkins.model.JobWithDetails;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author Peter Yu 2018/9/27 16:40
 */
public class App {

    public static void main(String[] args) {
        try {
            URI uri = new URI("http://10.101.85.171:8080/hudson");
            String username = "admin";
            String password = "amonjenkins";
            String jobName = "1000935_java_databank_web_test";

            JenkinsServer server = new JenkinsServer(uri, username, password);
            JobWithDetails job = server.getJob(jobName);
            String file = job.getFileFromWorkspace("target/site/jacoco/jacoco.xml");
            System.out.println(file);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
