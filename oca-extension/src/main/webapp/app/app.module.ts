import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

//
import { HttpClientModule, HttpClientJsonpModule } from '@angular/common/http'; // VL
//
import './vendor';
import { OracleCloudAppExtensionSharedModule } from 'app/shared/shared.module';
import { OracleCloudAppExtensionCoreModule } from 'app/core/core.module';
import { OracleCloudAppExtensionAppRoutingModule } from './app-routing.module';
import { OracleCloudAppExtensionHomeModule } from './home/home.module';
import { OracleCloudAppExtensionEntityModule } from './entities/entity.module';
// jhipster-needle-angular-add-module-import JHipster will add new module here
import { MainComponent } from './layouts/main/main.component';
import { NavbarComponent } from './layouts/navbar/navbar.component';
import { FooterComponent } from './layouts/footer/footer.component';
import { PageRibbonComponent } from './layouts/profiles/page-ribbon.component';
import { ErrorComponent } from './layouts/error/error.component';


@NgModule({
  imports: [
    BrowserModule,
    HttpClientModule, // VL
    HttpClientJsonpModule, // VL
    OracleCloudAppExtensionSharedModule,
    OracleCloudAppExtensionCoreModule,
    OracleCloudAppExtensionHomeModule,
    // jhipster-needle-angular-add-module JHipster will add new module here
    OracleCloudAppExtensionEntityModule,
    OracleCloudAppExtensionAppRoutingModule
  ],
  declarations: [MainComponent, NavbarComponent, ErrorComponent, PageRibbonComponent, FooterComponent],
  bootstrap: [MainComponent]
})
export class OracleCloudAppExtensionAppModule {}
