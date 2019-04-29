import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';
import { JhiLanguageService } from 'ng-jhipster';
import { JhiLanguageHelper } from 'app/core';

import { Newoapp1SharedModule } from 'app/shared';
import {
    EventoComponent,
    EventoDetailComponent,
    EventoUpdateComponent,
    EventoDeletePopupComponent,
    EventoDeleteDialogComponent,
    eventoRoute,
    eventoPopupRoute
} from './';

const ENTITY_STATES = [...eventoRoute, ...eventoPopupRoute];

@NgModule({
    imports: [Newoapp1SharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [EventoComponent, EventoDetailComponent, EventoUpdateComponent, EventoDeleteDialogComponent, EventoDeletePopupComponent],
    entryComponents: [EventoComponent, EventoUpdateComponent, EventoDeleteDialogComponent, EventoDeletePopupComponent],
    providers: [{ provide: JhiLanguageService, useClass: JhiLanguageService }],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class Newoapp1EventoModule {
    constructor(private languageService: JhiLanguageService, private languageHelper: JhiLanguageHelper) {
        this.languageHelper.language.subscribe((languageKey: string) => {
            if (languageKey !== undefined) {
                this.languageService.changeLanguage(languageKey);
            }
        });
    }
}
