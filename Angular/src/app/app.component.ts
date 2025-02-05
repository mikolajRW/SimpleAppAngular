import { Component} from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { DriverService } from './services/driverService';
import { CommonModule } from '@angular/common';
import { HttpClient, HttpClientModule} from '@angular/common/http';
import { AddCatComponent } from "../add-cat/add-cat.component";


@Component({
  selector: 'app-root',
  imports: [RouterOutlet],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'application';
}
