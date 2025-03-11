{{- define "booking-service.name" -}}
booking-service
{{- end -}}

{{- define "booking-service.fullname" -}}
{{ include "booking-service.name" . }}-{{ .Release.Name }}
{{- end -}}
