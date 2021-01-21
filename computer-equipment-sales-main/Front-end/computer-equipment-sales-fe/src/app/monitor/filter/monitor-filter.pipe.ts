import { Pipe, PipeTransform } from '@angular/core';
import {Monitor} from '../../model/monitor/monitor';

@Pipe({
  name: 'monitorFilter'
})
export class MonitorFilterPipe implements PipeTransform {

  transform(value: Monitor[], filterText?: string): Monitor[] {
    filterText = filterText ? filterText.toLocaleLowerCase() : null;

    return filterText ? value.filter((c: Monitor) => c.brand.toLocaleLowerCase().indexOf(filterText) !== -1) : value;
  }
}
