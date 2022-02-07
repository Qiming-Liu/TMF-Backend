package com.thinkmore.forum.dto.users;

import com.thinkmore.forum.dto.img.ImgGetDto;
import com.thinkmore.forum.dto.roles.RolesGetDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
public class UsersGetDto implements Serializable {
    private UUID id;
    private String username;
    private String password;
    private String email;
    private ImgGetDto profileImg;
    private RolesGetDto role;
    private OffsetDateTime lastLoginTimestamp;
    private OffsetDateTime createTimestamp;
}
