import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';
import { JhiLanguageService } from 'ng-jhipster';
import { JhiLanguageHelper } from 'app/core';

import { Newoapp1SharedModule } from 'app/shared';
import {
    EntradaMiembrosComponent,
    EntradaMiembrosDetailComponent,
    EntradaMiembrosUpdateComponent,
    EntradaMiembrosDeletePopupComponent,
    EntradaMiembrosDeleteDialogComponent,
    entradaMiembrosRoute,
    entradaMiembrosPopupRoute
} from './';

const ENTITY_STATES = [...entradaMiembrosRoute, ...entradaMiembrosPopupRoute];

@NgModule({
    imports: [Newoapp1SharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        EntradaMiembrosComponent,
        EntradaMiembrosDetailComponent,
        EntradaMiembrosUpdateComponent,
        EntradaMiembrosDeleteDialogComponent,
        EntradaMiembrosDeletePopupComponent
    ],
    entryComponents: [
        EntradaMiembrosComponent,
        EntradaMiembrosUpdateComponent,
        EntradaMiembrosDeleteDialogComponent,
        EntradaMiembrosDeletePopupComponent
    ],
    providers: [{ provide: JhiLanguageService, useClass: JhiLanguageService }],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class Newoapp1EntradaMiembrosModule {
    constructor(private languageService: JhiLanguageService, private languageHelper: JhiLanguageHelper) {
        this.languageHelper.language.subscribe((languageKey: string) => {
            if (languageKey !== undefined) {
                this.languageService.changeLanguage(languageKey);
            }
        });
    }
}
