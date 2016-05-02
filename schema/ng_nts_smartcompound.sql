CREATE TABLE "ng_nts_compounds" (
  "rec_id" SERIAL PRIMARY KEY,
  "compound_name" TEXT NOT NULL,
  "lattitude" DECIMAL(12, 2) NOT NULL,
  "longtude" DECIMAL(12, 2) NOT NULL,
  "country" TEXT NOT NULL,
  "city" TEXT NOT NULL,
  "owner_name" TEXT NOT NULL
);

CREATE TABLE "ng_nts_groups" (
  "rec_id" SERIAL PRIMARY KEY,
  "group_name" TEXT NOT NULL
);

CREATE TABLE "ng_nts_lookup_types" (
  "rec_id" SERIAL PRIMARY KEY,
  "type_name" TEXT NOT NULL
);

CREATE TABLE "ng_nts_lookup" (
  "rec_id" SERIAL PRIMARY KEY,
  "lookup_name" TEXT NOT NULL,
  "type_name" TEXT NOT NULL,
  "type_id" INTEGER NOT NULL
);

CREATE INDEX "idx_ng_nts_lookup__type_id" ON "ng_nts_lookup" ("type_id");

ALTER TABLE "ng_nts_lookup" ADD CONSTRAINT "fk_ng_nts_lookup__type_id" FOREIGN KEY ("type_id") REFERENCES "ng_nts_lookup_types" ("rec_id");

CREATE TABLE "ng_nts_employees" (
  "rec_id" SERIAL PRIMARY KEY,
  "salutation" TEXT NOT NULL,
  "username" TEXT NOT NULL,
  "password" TEXT NOT NULL,
  "first_name" TEXT NOT NULL,
  "middle_name" TEXT NOT NULL,
  "last_name" TEXT NOT NULL,
  "email" TEXT NOT NULL,
  "job" TEXT NOT NULL,
  "gender" TEXT NOT NULL,
  "identification_type" TEXT NOT NULL,
  "identification_number" TEXT NOT NULL,
  "address" TEXT NOT NULL,
  "phone_number1" TEXT NOT NULL,
  "phone_number2" TEXT NOT NULL,
  "mobile_number1" TEXT NOT NULL,
  "mobile_number2" TEXT NOT NULL,
  "status" TEXT NOT NULL,
  "hire_date" DATE NOT NULL,
  "group_name" TEXT NOT NULL,
  "compound_id" INTEGER NOT NULL,
  "salutation_lookup_id" INTEGER NOT NULL,
  "gender_lookup_id" INTEGER NOT NULL,
  "status_lookup_id" INTEGER NOT NULL,
  "group_id" INTEGER NOT NULL
);

CREATE INDEX "idx_ng_nts_employees__compound_id" ON "ng_nts_employees" ("compound_id");

CREATE INDEX "idx_ng_nts_employees__gender_lookup_id" ON "ng_nts_employees" ("gender_lookup_id");

CREATE INDEX "idx_ng_nts_employees__group_id" ON "ng_nts_employees" ("group_id");

CREATE INDEX "idx_ng_nts_employees__salutation_lookup_id" ON "ng_nts_employees" ("salutation_lookup_id");

CREATE INDEX "idx_ng_nts_employees__status_lookup_id" ON "ng_nts_employees" ("status_lookup_id");

ALTER TABLE "ng_nts_employees" ADD CONSTRAINT "fk_ng_nts_employees__compound_id" FOREIGN KEY ("compound_id") REFERENCES "ng_nts_compounds" ("rec_id");

ALTER TABLE "ng_nts_employees" ADD CONSTRAINT "fk_ng_nts_employees__gender_lookup_id" FOREIGN KEY ("gender_lookup_id") REFERENCES "ng_nts_lookup" ("rec_id");

ALTER TABLE "ng_nts_employees" ADD CONSTRAINT "fk_ng_nts_employees__group_id" FOREIGN KEY ("group_id") REFERENCES "ng_nts_groups" ("rec_id");

ALTER TABLE "ng_nts_employees" ADD CONSTRAINT "fk_ng_nts_employees__salutation_lookup_id" FOREIGN KEY ("salutation_lookup_id") REFERENCES "ng_nts_lookup" ("rec_id");

ALTER TABLE "ng_nts_employees" ADD CONSTRAINT "fk_ng_nts_employees__status_lookup_id" FOREIGN KEY ("status_lookup_id") REFERENCES "ng_nts_lookup" ("rec_id");

CREATE TABLE "ng_nts_services" (
  "rec_id" SERIAL PRIMARY KEY,
  "service_name" TEXT NOT NULL,
  "description" TEXT NOT NULL,
  "is_active" INTEGER NOT NULL,
  "severity" INTEGER NOT NULL,
  "flat_or_usage" TEXT NOT NULL,
  "estimated_delivery_days" INTEGER NOT NULL,
  "nrc" INTEGER NOT NULL,
  "mrc" INTEGER NOT NULL,
  "installation_price" INTEGER NOT NULL,
  "is_prepaid" INTEGER NOT NULL,
  "creation_date" TIMESTAMP NOT NULL,
  "measuring_unit" TEXT NOT NULL,
  "compound_id" INTEGER NOT NULL,
  "measuring_unit_lookup_id" INTEGER NOT NULL
);

CREATE INDEX "idx_ng_nts_services__compound_id" ON "ng_nts_services" ("compound_id");

CREATE INDEX "idx_ng_nts_services__measuring_unit_lookup_id" ON "ng_nts_services" ("measuring_unit_lookup_id");

ALTER TABLE "ng_nts_services" ADD CONSTRAINT "fk_ng_nts_services__compound_id" FOREIGN KEY ("compound_id") REFERENCES "ng_nts_compounds" ("rec_id");

ALTER TABLE "ng_nts_services" ADD CONSTRAINT "fk_ng_nts_services__measuring_unit_lookup_id" FOREIGN KEY ("measuring_unit_lookup_id") REFERENCES "ng_nts_lookup" ("rec_id");

CREATE TABLE "ng_nts_service_usage_rates" (
  "rec_id" SERIAL PRIMARY KEY,
  "usage_amount_from" DECIMAL(12, 2) NOT NULL,
  "usage_amount_to" DECIMAL(12, 2) NOT NULL,
  "unit_price" DECIMAL(12, 2) NOT NULL,
  "service_name" TEXT NOT NULL,
  "compound_id" INTEGER NOT NULL,
  "service_id" INTEGER NOT NULL
);

CREATE INDEX "idx_ng_nts_service_usage_rates__compound_id" ON "ng_nts_service_usage_rates" ("compound_id");

CREATE INDEX "idx_ng_nts_service_usage_rates__service_id" ON "ng_nts_service_usage_rates" ("service_id");

ALTER TABLE "ng_nts_service_usage_rates" ADD CONSTRAINT "fk_ng_nts_service_usage_rates__compound_id" FOREIGN KEY ("compound_id") REFERENCES "ng_nts_compounds" ("rec_id");

ALTER TABLE "ng_nts_service_usage_rates" ADD CONSTRAINT "fk_ng_nts_service_usage_rates__service_id" FOREIGN KEY ("service_id") REFERENCES "ng_nts_services" ("rec_id");

CREATE TABLE "ng_nts_tenants" (
  "rec_id" SERIAL PRIMARY KEY,
  "salutation" TEXT NOT NULL,
  "username" TEXT NOT NULL,
  "password" TEXT NOT NULL,
  "first_name" TEXT NOT NULL,
  "middle_name" TEXT NOT NULL,
  "last_name" TEXT NOT NULL,
  "email" TEXT NOT NULL,
  "job" TEXT NOT NULL,
  "gender" TEXT NOT NULL,
  "nationality" TEXT NOT NULL,
  "date_of_birth" DATE NOT NULL,
  "identification_type" TEXT NOT NULL,
  "identification_number" TEXT NOT NULL,
  "best_connection_method" TEXT NOT NULL,
  "address" TEXT NOT NULL,
  "country" TEXT NOT NULL,
  "city" TEXT NOT NULL,
  "postal_code" TEXT NOT NULL,
  "phone_number1" TEXT NOT NULL,
  "phone_number2" TEXT NOT NULL,
  "mobile_number1" TEXT NOT NULL,
  "mobile_number2" TEXT NOT NULL,
  "facebook" TEXT NOT NULL,
  "whatsapp" TEXT NOT NULL,
  "compound_id" INTEGER NOT NULL,
  "salutation_lookup_id" INTEGER NOT NULL,
  "gender_lookup_id" INTEGER NOT NULL
);

CREATE INDEX "idx_ng_nts_tenants__compound_id" ON "ng_nts_tenants" ("compound_id");

CREATE INDEX "idx_ng_nts_tenants__gender_lookup_id" ON "ng_nts_tenants" ("gender_lookup_id");

CREATE INDEX "idx_ng_nts_tenants__salutation_lookup_id" ON "ng_nts_tenants" ("salutation_lookup_id");

ALTER TABLE "ng_nts_tenants" ADD CONSTRAINT "fk_ng_nts_tenants__compound_id" FOREIGN KEY ("compound_id") REFERENCES "ng_nts_compounds" ("rec_id");

ALTER TABLE "ng_nts_tenants" ADD CONSTRAINT "fk_ng_nts_tenants__gender_lookup_id" FOREIGN KEY ("gender_lookup_id") REFERENCES "ng_nts_lookup" ("rec_id");

ALTER TABLE "ng_nts_tenants" ADD CONSTRAINT "fk_ng_nts_tenants__salutation_lookup_id" FOREIGN KEY ("salutation_lookup_id") REFERENCES "ng_nts_lookup" ("rec_id");

CREATE TABLE "ng_nts_facilities" (
  "rec_id" SERIAL PRIMARY KEY,
  "facility_type" TEXT NOT NULL,
  "block" TEXT,
  "street" TEXT,
  "building_number" INTEGER NOT NULL,
  "floor_number" INTEGER NOT NULL,
  "facility_number" INTEGER NOT NULL,
  "lattitude" DECIMAL(12, 2) NOT NULL,
  "longtude" DECIMAL(12, 2) NOT NULL,
  "status" TEXT,
  "is_for_rent" INTEGER NOT NULL,
  "area" DECIMAL(12, 2) NOT NULL,
  "description" TEXT,
  "picture_url" TEXT,
  "compound_id" INTEGER NOT NULL,
  "tenant_id" INTEGER NOT NULL,
  "facility_lookup_id" INTEGER NOT NULL
);

CREATE INDEX "idx_ng_nts_facilities__compound_id" ON "ng_nts_facilities" ("compound_id");

CREATE INDEX "idx_ng_nts_facilities__facility_lookup_id" ON "ng_nts_facilities" ("facility_lookup_id");

CREATE INDEX "idx_ng_nts_facilities__tenant_id" ON "ng_nts_facilities" ("tenant_id");

ALTER TABLE "ng_nts_facilities" ADD CONSTRAINT "fk_ng_nts_facilities__compound_id" FOREIGN KEY ("compound_id") REFERENCES "ng_nts_compounds" ("rec_id");

ALTER TABLE "ng_nts_facilities" ADD CONSTRAINT "fk_ng_nts_facilities__facility_lookup_id" FOREIGN KEY ("facility_lookup_id") REFERENCES "ng_nts_lookup" ("rec_id");

ALTER TABLE "ng_nts_facilities" ADD CONSTRAINT "fk_ng_nts_facilities__tenant_id" FOREIGN KEY ("tenant_id") REFERENCES "ng_nts_tenants" ("rec_id");

CREATE TABLE "Ng_nts_tenant_facilities" (
  "rec_id" SERIAL PRIMARY KEY,
  "is_leased" INTEGER NOT NULL,
  "leasing_or_ownership_start_date" DATE NOT NULL,
  "leasing_or_ownership_end_date" DATE NOT NULL,
  "compound_id" INTEGER NOT NULL,
  "tenant_id" INTEGER NOT NULL,
  "facility_id" INTEGER NOT NULL
);

CREATE INDEX "idx_ng_nts_tenant_facilities__compound_id" ON "Ng_nts_tenant_facilities" ("compound_id");

CREATE INDEX "idx_ng_nts_tenant_facilities__facility_id" ON "Ng_nts_tenant_facilities" ("facility_id");

CREATE INDEX "idx_ng_nts_tenant_facilities__tenant_id" ON "Ng_nts_tenant_facilities" ("tenant_id");

ALTER TABLE "Ng_nts_tenant_facilities" ADD CONSTRAINT "fk_ng_nts_tenant_facilities__compound_id" FOREIGN KEY ("compound_id") REFERENCES "ng_nts_compounds" ("rec_id");

ALTER TABLE "Ng_nts_tenant_facilities" ADD CONSTRAINT "fk_ng_nts_tenant_facilities__facility_id" FOREIGN KEY ("facility_id") REFERENCES "ng_nts_facilities" ("rec_id");

ALTER TABLE "Ng_nts_tenant_facilities" ADD CONSTRAINT "fk_ng_nts_tenant_facilities__tenant_id" FOREIGN KEY ("tenant_id") REFERENCES "ng_nts_tenants" ("rec_id");

CREATE TABLE "ng_nts_orders" (
  "rec_id" SERIAL PRIMARY KEY,
  "service_name" TEXT NOT NULL,
  "request_date" DATE NOT NULL,
  "acceptence_date" DATE NOT NULL,
  "status" TEXT NOT NULL,
  "channel" TEXT NOT NULL,
  "notes" TEXT NOT NULL,
  "service_location_lattitude" DECIMAL(12, 2) NOT NULL,
  "service_location_longtude" DECIMAL(12, 2) NOT NULL,
  "service_location_desc" TEXT NOT NULL,
  "compound_id" INTEGER NOT NULL,
  "tenant_id" INTEGER NOT NULL,
  "service_id" INTEGER NOT NULL,
  "facility_id" INTEGER NOT NULL,
  "created_by" INTEGER NOT NULL,
  "accepted_by" INTEGER,
  "channel_lookup_id" INTEGER NOT NULL
);

CREATE INDEX "idx_ng_nts_orders__accepted_by" ON "ng_nts_orders" ("accepted_by");

CREATE INDEX "idx_ng_nts_orders__channel_lookup_id" ON "ng_nts_orders" ("channel_lookup_id");

CREATE INDEX "idx_ng_nts_orders__compound_id" ON "ng_nts_orders" ("compound_id");

CREATE INDEX "idx_ng_nts_orders__created_by" ON "ng_nts_orders" ("created_by");

CREATE INDEX "idx_ng_nts_orders__facility_id" ON "ng_nts_orders" ("facility_id");

CREATE INDEX "idx_ng_nts_orders__service_id" ON "ng_nts_orders" ("service_id");

CREATE INDEX "idx_ng_nts_orders__tenant_id" ON "ng_nts_orders" ("tenant_id");

ALTER TABLE "ng_nts_orders" ADD CONSTRAINT "fk_ng_nts_orders__accepted_by" FOREIGN KEY ("accepted_by") REFERENCES "ng_nts_employees" ("rec_id");

ALTER TABLE "ng_nts_orders" ADD CONSTRAINT "fk_ng_nts_orders__channel_lookup_id" FOREIGN KEY ("channel_lookup_id") REFERENCES "ng_nts_lookup" ("rec_id");

ALTER TABLE "ng_nts_orders" ADD CONSTRAINT "fk_ng_nts_orders__compound_id" FOREIGN KEY ("compound_id") REFERENCES "ng_nts_compounds" ("rec_id");

ALTER TABLE "ng_nts_orders" ADD CONSTRAINT "fk_ng_nts_orders__created_by" FOREIGN KEY ("created_by") REFERENCES "ng_nts_employees" ("rec_id");

ALTER TABLE "ng_nts_orders" ADD CONSTRAINT "fk_ng_nts_orders__facility_id" FOREIGN KEY ("facility_id") REFERENCES "ng_nts_facilities" ("rec_id");

ALTER TABLE "ng_nts_orders" ADD CONSTRAINT "fk_ng_nts_orders__service_id" FOREIGN KEY ("service_id") REFERENCES "ng_nts_services" ("rec_id");

ALTER TABLE "ng_nts_orders" ADD CONSTRAINT "fk_ng_nts_orders__tenant_id" FOREIGN KEY ("tenant_id") REFERENCES "ng_nts_tenants" ("rec_id");

CREATE TABLE "ng_nts_tickets" (
  "rec_id" SERIAL PRIMARY KEY,
  "ticket_subject" TEXT,
  "description" TEXT,
  "problem_date" TIMESTAMP NOT NULL,
  "open_date" TIMESTAMP NOT NULL,
  "channel" TEXT,
  "last_status" TEXT,
  "severity" INTEGER NOT NULL,
  "feedback" TEXT NOT NULL,
  "rate" INTEGER NOT NULL,
  "service_name" TEXT NOT NULL,
  "compound_id" INTEGER NOT NULL,
  "facility_id" INTEGER NOT NULL,
  "service_id" INTEGER NOT NULL,
  "related_tenant_id" INTEGER NOT NULL,
  "assigned_group_id" INTEGER NOT NULL,
  "opened_by" INTEGER NOT NULL,
  "channel_lookup_id" INTEGER NOT NULL,
  "group_name" TEXT
);

CREATE INDEX "idx_ng_nts_tickets__assigned_group_id" ON "ng_nts_tickets" ("assigned_group_id");

CREATE INDEX "idx_ng_nts_tickets__channel_lookup_id" ON "ng_nts_tickets" ("channel_lookup_id");

CREATE INDEX "idx_ng_nts_tickets__compound_id" ON "ng_nts_tickets" ("compound_id");

CREATE INDEX "idx_ng_nts_tickets__facility_id" ON "ng_nts_tickets" ("facility_id");

CREATE INDEX "idx_ng_nts_tickets__opened_by" ON "ng_nts_tickets" ("opened_by");

CREATE INDEX "idx_ng_nts_tickets__related_tenant_id" ON "ng_nts_tickets" ("related_tenant_id");

CREATE INDEX "idx_ng_nts_tickets__service_id" ON "ng_nts_tickets" ("service_id");

ALTER TABLE "ng_nts_tickets" ADD CONSTRAINT "fk_ng_nts_tickets__assigned_group_id" FOREIGN KEY ("assigned_group_id") REFERENCES "ng_nts_groups" ("rec_id");

ALTER TABLE "ng_nts_tickets" ADD CONSTRAINT "fk_ng_nts_tickets__channel_lookup_id" FOREIGN KEY ("channel_lookup_id") REFERENCES "ng_nts_lookup" ("rec_id");

ALTER TABLE "ng_nts_tickets" ADD CONSTRAINT "fk_ng_nts_tickets__compound_id" FOREIGN KEY ("compound_id") REFERENCES "ng_nts_compounds" ("rec_id");

ALTER TABLE "ng_nts_tickets" ADD CONSTRAINT "fk_ng_nts_tickets__facility_id" FOREIGN KEY ("facility_id") REFERENCES "ng_nts_facilities" ("rec_id");

ALTER TABLE "ng_nts_tickets" ADD CONSTRAINT "fk_ng_nts_tickets__opened_by" FOREIGN KEY ("opened_by") REFERENCES "ng_nts_employees" ("rec_id");

ALTER TABLE "ng_nts_tickets" ADD CONSTRAINT "fk_ng_nts_tickets__related_tenant_id" FOREIGN KEY ("related_tenant_id") REFERENCES "ng_nts_tenants" ("rec_id");

ALTER TABLE "ng_nts_tickets" ADD CONSTRAINT "fk_ng_nts_tickets__service_id" FOREIGN KEY ("service_id") REFERENCES "ng_nts_services" ("rec_id");

CREATE TABLE "ng_nts_tickets_histories" (
  "rec_id" SERIAL PRIMARY KEY,
  "action_date" TIMESTAMP NOT NULL,
  "is_completed" INTEGER NOT NULL,
  "comment" TEXT NOT NULL,
  "previous_status" TEXT NOT NULL,
  "currenet_status" TEXT NOT NULL,
  "compound_id" INTEGER NOT NULL,
  "ticket_id" INTEGER NOT NULL,
  "action_by" INTEGER NOT NULL,
  "opened_by" INTEGER NOT NULL
);

CREATE INDEX "idx_ng_nts_tickets_histories__action_by" ON "ng_nts_tickets_histories" ("action_by");

CREATE INDEX "idx_ng_nts_tickets_histories__compound_id" ON "ng_nts_tickets_histories" ("compound_id");

CREATE INDEX "idx_ng_nts_tickets_histories__opened_by" ON "ng_nts_tickets_histories" ("opened_by");

CREATE INDEX "idx_ng_nts_tickets_histories__ticket_id" ON "ng_nts_tickets_histories" ("ticket_id");

ALTER TABLE "ng_nts_tickets_histories" ADD CONSTRAINT "fk_ng_nts_tickets_histories__action_by" FOREIGN KEY ("action_by") REFERENCES "ng_nts_employees" ("rec_id");

ALTER TABLE "ng_nts_tickets_histories" ADD CONSTRAINT "fk_ng_nts_tickets_histories__compound_id" FOREIGN KEY ("compound_id") REFERENCES "ng_nts_compounds" ("rec_id");

ALTER TABLE "ng_nts_tickets_histories" ADD CONSTRAINT "fk_ng_nts_tickets_histories__opened_by" FOREIGN KEY ("opened_by") REFERENCES "ng_nts_employees" ("rec_id");

ALTER TABLE "ng_nts_tickets_histories" ADD CONSTRAINT "fk_ng_nts_tickets_histories__ticket_id" FOREIGN KEY ("ticket_id") REFERENCES "ng_nts_tickets" ("rec_id")