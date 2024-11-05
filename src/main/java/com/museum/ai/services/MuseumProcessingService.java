package com.museum.ai.services;

import com.museum.ai.exceptions.InvalidDataException;
import com.museum.ai.http_clients.DownloadHttpClient;
import com.museum.ai.http_clients.MetmuseumHttpClient;
import com.museum.ai.model.DescribedImageResponse;
import com.museum.ai.model.MetmuseumDepartmentResponse;
import com.museum.ai.model.MetmuseumObjectResponse;
import com.museum.ai.model.MetmuseumSearchResponse;
import com.museum.ai.utils.ImageDescriptionParser;
import com.museum.ai.utils.PromptUtil;
import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.data.message.ImageContent;
import dev.langchain4j.data.message.TextContent;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.model.output.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.Base64;
import java.util.HashMap;

@Service
@Slf4j
@RequiredArgsConstructor
public class MuseumProcessingService {
    private final OpenAiChatModel visionModel;
    private final DownloadHttpClient downloadHttpClient;
    private final MetmuseumHttpClient metmuseumHttpClient;

    public MetmuseumDepartmentResponse getDepartments() {
        try {
            return metmuseumHttpClient.getDepartments();
        } catch (Exception e) {
            throw new InvalidDataException(e.getMessage());
        }
    }

    public MetmuseumSearchResponse searchObjectsByQuery(String query) {
        try {
            return metmuseumHttpClient.searchObjectsByQuery(query);
        } catch (Exception e) {
            throw new InvalidDataException(e.getMessage());
        }
    }

    public MetmuseumSearchResponse searchObjectsByDepartmentId(Integer departmentId) {
        try {
            return metmuseumHttpClient.searchObjectsByDepartmentId(departmentId);
        } catch (Exception e) {
            throw new InvalidDataException(e.getMessage());
        }
    }

    public MetmuseumObjectResponse getMetmuseumObject(Integer id) {
        try {
            return metmuseumHttpClient.getMetmuseumObject(id);
        } catch (Exception e) {
            throw new InvalidDataException(e.getMessage());
        }
    }

    public DescribedImageResponse describeImage(String imageUrl) {
        try {
            byte[] image = downloadHttpClient.download(URI.create(imageUrl).toURL());
            return describeImage(image);
        } catch (Exception e) {
            throw new InvalidDataException(e.getMessage());
        }
    }

    private DescribedImageResponse describeImage(byte[] imageData) throws Exception {
        var systemPrompt = PromptUtil.loadPromptTemplate(this.getClass(), "describe_image.txt").apply(new HashMap<>());

        var imageContent = ImageContent.from(Base64.getEncoder().encodeToString(imageData), "image/png", ImageContent.DetailLevel.AUTO);
        var textContent = new TextContent(systemPrompt.text());
        var message = UserMessage.from(textContent, imageContent);
        Response<AiMessage> response = visionModel.generate(message);
        String text = response.content().text();
        log.info(text);

        var outputParser = new ImageDescriptionParser();
        return outputParser.parse(text);
    }
}
