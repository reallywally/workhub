package com.wally.workhub.domain.advertiser.web;

import com.wally.workhub.domain.advertiser.model.ProjectCreate;
import com.wally.workhub.domain.advertiser.model.ProjectEdit;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ProjectController {

    @GetMapping("/advertiser/{advertiserId}/projects")
    public String getProjects() {
        return "프로젝트 목록 조회";
    }

    @GetMapping("/projects/{projectId}")
    public String getProjectById(@PathVariable Long projectId) {
        return "프로젝트 단건 조회";
    }

    @PostMapping("/projects")
    public String createProjects(@RequestBody ProjectCreate projectCreate) {
        return "프로젝트 등록";
    }

    @PatchMapping("/projects/{projectId}")
    public String updateProject(@PathVariable Long projectId, @RequestBody ProjectEdit projectEdit) {
        return "프로젝트 수정";
    }

    @DeleteMapping("/projects/{projectId}")
    public String deleteProject(@PathVariable Long projectId) {
        return "프로젝트 삭제";
    }

    @PostMapping("/projects/{projectId}/managers/{managerId}")
    public String addProjectManager(@PathVariable Long projectId, @PathVariable Long managerId) {
        return "프로젝트 담당자 추가";
    }

    @DeleteMapping("/projects/{projectId}/managers/{managerId}")
    public String removeProjectManager(@PathVariable Long projectId, @PathVariable Long managerId) {
        return "프로젝트 담당자 삭제";
    }
}
