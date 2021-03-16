package com.moacirknipers.app.controllers;

import com.moacirknipers.app.entities.Installation;
import com.moacirknipers.app.services.InstallationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Api(value = "Installations Service")
public class InstallationsController {

    @Autowired
    private InstallationService service;

    @ApiOperation(value = "Installations list")
    @GetMapping("installations")
    public List<Installation> getAllInstallations() {
        return service.getAllInstallations();
    }


    @ApiOperation(value = "Find installation by installation code")
    @GetMapping("installations/{installationCode}")
    public Optional<Installation> getInstallation(@PathVariable String installationCode) {
        return service.getByInstallationCode(installationCode);
    }

    @ApiOperation(value = "Find installation by customer identity document")
    @GetMapping("installations/identitydocument/{identityDocument}")
    public List<Installation> getInstallationsByIdentityDocument(@PathVariable String identityDocument) {
        return service.getInstallationsByCustomerIdentityDocument(identityDocument);
    }

    @ApiOperation(value = "Register a new installation")
    @PostMapping("installations")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Installation> createInstallation(@RequestBody Installation installation) {
        return service.registerNewInstallation(installation);
    }

}
