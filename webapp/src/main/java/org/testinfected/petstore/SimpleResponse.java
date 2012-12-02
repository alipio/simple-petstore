package org.testinfected.petstore;

import org.simpleframework.http.Response;
import org.simpleframework.http.Status;
import org.testinfected.support.RenderingEngine;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

import static org.simpleframework.http.Status.SEE_OTHER;

public class SimpleResponse implements Controller.Response {

    private final Response response;
    private final RenderingEngine renderer;
    private final Charset charset;

    public SimpleResponse(Response response, RenderingEngine renderer, Charset charset) {
        this.response = response;
        this.renderer = renderer;
        this.charset = charset;
    }

    public void render(String view, Object context) throws IOException {
        response.set("Content-Type", "text/html; charset=" + charset.name().toLowerCase());
        OutputStreamWriter out = new OutputStreamWriter(response.getOutputStream(), charset);
        renderer.render(out, view, context);
        out.flush();
    }

    public void renderHead(int statusCode) {
        response.setCode(statusCode);
        response.setText(Status.getDescription(statusCode));
    }

    public void redirectTo(String location) {
        renderHead(SEE_OTHER.getCode());
        response.set("Location", location);
    }
}
