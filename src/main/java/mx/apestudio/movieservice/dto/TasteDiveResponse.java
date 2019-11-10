package mx.apestudio.movieservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collection;
import java.util.List;

public class TasteDiveResponse {
    @JsonProperty("Similar")
    Similar similar;

    public TasteDiveResponse(){}

    public Similar getSimilar() {
        return similar;
    }

    public void setSimilar(Similar similar) {
        this.similar = similar;
    }

    @Override
    public String toString() {
        return "TasteDiveResponse{" +
                "similar=" + similar +
                '}';
    }

    public static class Similar {
        @JsonProperty("Info")
        List<Info> info;

        public Similar(){}

        public List<Info> getInfo() {
            return info;
        }

        public void setInfo(List<Info> info) {
            this.info = info;
        }

        @Override
        public String toString() {
            return "Similar{" +
                    "info=" + info +
                    '}';
        }
    }

    public static class Info {
        @JsonProperty("Name")
        String name;
        @JsonProperty("Type")
        String type;
        @JsonProperty("yUrl")
        String youtubeUrl;

        public Info(){}

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getYoutubeUrl() {
            return youtubeUrl;
        }

        public void setYoutubeUrl(String youtubeUrl) {
            this.youtubeUrl = youtubeUrl;
        }

        @Override
        public String toString() {
            return "Info{" +
                    "name='" + name + '\'' +
                    ", type='" + type + '\'' +
                    ", youtubeUrl='" + youtubeUrl + '\'' +
                    '}';
        }
    }
}
