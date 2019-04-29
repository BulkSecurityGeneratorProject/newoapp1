package io.github.jhipster.application.web.rest;
import io.github.jhipster.application.domain.MiembrosEquipoEmpresas;
import io.github.jhipster.application.repository.MiembrosEquipoEmpresasRepository;
import io.github.jhipster.application.web.rest.errors.BadRequestAlertException;
import io.github.jhipster.application.web.rest.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing MiembrosEquipoEmpresas.
 */
@RestController
@RequestMapping("/api")
public class MiembrosEquipoEmpresasResource {

    private final Logger log = LoggerFactory.getLogger(MiembrosEquipoEmpresasResource.class);

    private static final String ENTITY_NAME = "miembrosEquipoEmpresas";

    private final MiembrosEquipoEmpresasRepository miembrosEquipoEmpresasRepository;

    public MiembrosEquipoEmpresasResource(MiembrosEquipoEmpresasRepository miembrosEquipoEmpresasRepository) {
        this.miembrosEquipoEmpresasRepository = miembrosEquipoEmpresasRepository;
    }

    /**
     * POST  /miembros-equipo-empresas : Create a new miembrosEquipoEmpresas.
     *
     * @param miembrosEquipoEmpresas the miembrosEquipoEmpresas to create
     * @return the ResponseEntity with status 201 (Created) and with body the new miembrosEquipoEmpresas, or with status 400 (Bad Request) if the miembrosEquipoEmpresas has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/miembros-equipo-empresas")
    public ResponseEntity<MiembrosEquipoEmpresas> createMiembrosEquipoEmpresas(@RequestBody MiembrosEquipoEmpresas miembrosEquipoEmpresas) throws URISyntaxException {
        log.debug("REST request to save MiembrosEquipoEmpresas : {}", miembrosEquipoEmpresas);
        if (miembrosEquipoEmpresas.getId() != null) {
            throw new BadRequestAlertException("A new miembrosEquipoEmpresas cannot already have an ID", ENTITY_NAME, "idexists");
        }
        MiembrosEquipoEmpresas result = miembrosEquipoEmpresasRepository.save(miembrosEquipoEmpresas);
        return ResponseEntity.created(new URI("/api/miembros-equipo-empresas/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /miembros-equipo-empresas : Updates an existing miembrosEquipoEmpresas.
     *
     * @param miembrosEquipoEmpresas the miembrosEquipoEmpresas to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated miembrosEquipoEmpresas,
     * or with status 400 (Bad Request) if the miembrosEquipoEmpresas is not valid,
     * or with status 500 (Internal Server Error) if the miembrosEquipoEmpresas couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/miembros-equipo-empresas")
    public ResponseEntity<MiembrosEquipoEmpresas> updateMiembrosEquipoEmpresas(@RequestBody MiembrosEquipoEmpresas miembrosEquipoEmpresas) throws URISyntaxException {
        log.debug("REST request to update MiembrosEquipoEmpresas : {}", miembrosEquipoEmpresas);
        if (miembrosEquipoEmpresas.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        MiembrosEquipoEmpresas result = miembrosEquipoEmpresasRepository.save(miembrosEquipoEmpresas);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, miembrosEquipoEmpresas.getId().toString()))
            .body(result);
    }

    /**
     * GET  /miembros-equipo-empresas : get all the miembrosEquipoEmpresas.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of miembrosEquipoEmpresas in body
     */
    @GetMapping("/miembros-equipo-empresas")
    public List<MiembrosEquipoEmpresas> getAllMiembrosEquipoEmpresas() {
        log.debug("REST request to get all MiembrosEquipoEmpresas");
        return miembrosEquipoEmpresasRepository.findAll();
    }

    /**
     * GET  /miembros-equipo-empresas/:id : get the "id" miembrosEquipoEmpresas.
     *
     * @param id the id of the miembrosEquipoEmpresas to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the miembrosEquipoEmpresas, or with status 404 (Not Found)
     */
    @GetMapping("/miembros-equipo-empresas/{id}")
    public ResponseEntity<MiembrosEquipoEmpresas> getMiembrosEquipoEmpresas(@PathVariable Long id) {
        log.debug("REST request to get MiembrosEquipoEmpresas : {}", id);
        Optional<MiembrosEquipoEmpresas> miembrosEquipoEmpresas = miembrosEquipoEmpresasRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(miembrosEquipoEmpresas);
    }

    /**
     * DELETE  /miembros-equipo-empresas/:id : delete the "id" miembrosEquipoEmpresas.
     *
     * @param id the id of the miembrosEquipoEmpresas to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/miembros-equipo-empresas/{id}")
    public ResponseEntity<Void> deleteMiembrosEquipoEmpresas(@PathVariable Long id) {
        log.debug("REST request to delete MiembrosEquipoEmpresas : {}", id);
        miembrosEquipoEmpresasRepository.deleteById(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
