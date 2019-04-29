/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { Newoapp1TestModule } from '../../../test.module';
import { LandingDetailComponent } from 'app/entities/landing/landing-detail.component';
import { Landing } from 'app/shared/model/landing.model';

describe('Component Tests', () => {
    describe('Landing Management Detail Component', () => {
        let comp: LandingDetailComponent;
        let fixture: ComponentFixture<LandingDetailComponent>;
        const route = ({ data: of({ landing: new Landing(123) }) } as any) as ActivatedRoute;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [Newoapp1TestModule],
                declarations: [LandingDetailComponent],
                providers: [{ provide: ActivatedRoute, useValue: route }]
            })
                .overrideTemplate(LandingDetailComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(LandingDetailComponent);
            comp = fixture.componentInstance;
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(comp.landing).toEqual(jasmine.objectContaining({ id: 123 }));
            });
        });
    });
});
