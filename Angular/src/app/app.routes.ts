import { Routes } from '@angular/router';
import { AddCatComponent } from '../add-cat/add-cat.component';
import { AppComponent } from './app.component';
import { ViewcatComponent } from '../viewcat/viewcat.component';
import { EditCatComponent } from '../edit-cat/edit-cat.component';
import { ViewCatElemComponent } from '../view-cat-elem/view-cat-elem.component';
import { AddElementComponent } from '../add-element/add-element.component';
import { EditElementComponent } from '../edit-element/edit-element.component';
import { ElementDetailsComponent } from '../element-details/element-details.component';
export const routes: Routes = [
    {path: 'add', component:AddCatComponent},
    {path:'view', component:ViewcatComponent},
    {path:'edit', component:EditCatComponent},
    {path:'viewDetailed', component:ViewCatElemComponent},
    {path: 'addElem/:driverId', component:AddElementComponent},
    {path:'editElem/:id', component:EditElementComponent},
    {path:'detailsElem', component:ElementDetailsComponent}
];
