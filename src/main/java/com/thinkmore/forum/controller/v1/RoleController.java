package com.thinkmore.forum.controller.v1;

import com.thinkmore.forum.dto.roles.RolesGetDto;
import com.thinkmore.forum.dto.roles.RolesPutDto;
import com.thinkmore.forum.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/v1/role")
@RequiredArgsConstructor
public class RoleController {
    private final RoleService roleService;

    @GetMapping(path="/all")
    public ResponseEntity<List<RolesGetDto>> getAllRoles() { return ResponseEntity.ok(roleService.getAllRoles());}

    @PutMapping
    public  ResponseEntity<Boolean> putRole(@RequestBody List<RolesPutDto> rolesPutDtoList) {
        return ResponseEntity.ok(roleService.putRole(rolesPutDtoList));
    }

}
