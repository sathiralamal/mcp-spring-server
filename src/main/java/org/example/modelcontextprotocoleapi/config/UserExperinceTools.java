package org.example.modelcontextprotocoleapi.config;

import org.example.modelcontextprotocoleapi.service.MCPService;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserExperinceTools {

    @Bean
    public ToolCallbackProvider UserExperinceTools(MCPService mcpService) {
        return  MethodToolCallbackProvider.builder().toolObjects(mcpService).build();
    }
}
