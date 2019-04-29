/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable, of } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';

import { Newoapp1TestModule } from '../../../test.module';
import { EmpresaDeleteDialogComponent } from 'app/entities/empresa/empresa-delete-dialog.component';
import { EmpresaService } from 'app/entities/empresa/empresa.service';

describe('Component Tests', () => {
    describe('Empresa Management Delete Component', () => {
        let comp: EmpresaDeleteDialogComponent;
        let fixture: ComponentFixture<EmpresaDeleteDialogComponent>;
        let service: EmpresaService;
        let mockEventManager: any;
        let mockActiveModal: any;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [Newoapp1TestModule],
                declarations: [EmpresaDeleteDialogComponent]
            })
                .overrideTemplate(EmpresaDeleteDialogComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(EmpresaDeleteDialogComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(EmpresaService);
            mockEventManager = fixture.debugElement.injector.get(JhiEventManager);
            mockActiveModal = fixture.debugElement.injector.get(NgbActiveModal);
        });

        describe('confirmDelete', () => {
            it('Should call delete service on confirmDelete', inject(
                [],
                fakeAsync(() => {
                    // GIVEN
                    spyOn(service, 'delete').and.returnValue(of({}));

                    // WHEN
                    comp.confirmDelete(123);
                    tick();

                    // THEN
                    expect(service.delete).toHaveBeenCalledWith(123);
                    expect(mockActiveModal.dismissSpy).toHaveBeenCalled();
                    expect(mockEventManager.broadcastSpy).toHaveBeenCalled();
                })
            ));
        });
    });
});