package com.SBMS.SBMS.Dto;

import java.util.List;

public record UsersResponse(List<UserDto> users, Integer total, Integer skip, Integer limit) {
}
